using System;
using System.Drawing;

namespace ConsoleApplication1
{
// https://stackoverflow.com/questions/12408431/how-can-i-get-the-average-color-of-an-image
    public static class ColorUtil
    {
        public static int argb(int R, int G, int B)
        {
            return argb(int.MaxValue, R, G, B);
        }

        public static int argb(int A, int R, int G, int B)
        {
            byte[] colorByteArr = {(byte) A, (byte) R, (byte) G, (byte) B};
            return byteArrToInt(colorByteArr);
        }

        public static int[] rgb(int argb)
        {
            return new int[] {(argb >> 16) & 0xFF, (argb >> 8) & 0xFF, argb & 0xFF};
        }

        public static int byteArrToInt(byte[] colorByteArr)
        {
            return (colorByteArr[0] << 24) + ((colorByteArr[1] & 0xFF) << 16)
                                           + ((colorByteArr[2] & 0xFF) << 8) + (colorByteArr[3] & 0xFF);
        }

        public static int[] rgb2lab(int R, int G, int B)
        {
            //http://www.brucelindbloom.com

            float r, g, b, X, Y, Z, fx, fy, fz, xr, yr, zr;
            float _ls, _as, _bs;
            float eps = 216.0f / 24389.0f;
            float k = 24389.0f / 27.0f;

            float Xr = 0.964221f; // reference white D50
            float Yr = 1.0f;
            float Zr = 0.825211f;

            // RGB to XYZ
            r = R / 255.0f; //R 0..1
            g = G / 255.0f; //G 0..1
            b = B / 255.0f; //B 0..1

            // assuming sRGB (D65)
            if (r <= 0.04045)
                r = r / 12.92f;
            else
                r = (float) Math.Pow((r + 0.055) / 1.055, 2.4);

            if (g <= 0.04045)
                g = g / 12.92f;
            else
                g = (float) Math.Pow((g + 0.055) / 1.055, 2.4);

            if (b <= 0.04045)
                b = b / 12.92f;
            else
                b = (float) Math.Pow((b + 0.055) / 1.055, 2.4);


            X = 0.436052025f * r + 0.385081593f * g + 0.143087414f * b;
            Y = 0.222491598f * r + 0.71688606f * g + 0.060621486f * b;
            Z = 0.013929122f * r + 0.097097002f * g + 0.71418547f * b;

            // XYZ to Lab
            xr = X / Xr;
            yr = Y / Yr;
            zr = Z / Zr;

            if (xr > eps)
                fx = (float) Math.Pow(xr, 1 / 3.0);
            else
                fx = (float) ((k * xr + 16.0) / 116.0);

            if (yr > eps)
                fy = (float) Math.Pow(yr, 1 / 3.0);
            else
                fy = (float) ((k * yr + 16.0) / 116.0);

            if (zr > eps)
                fz = (float) Math.Pow(zr, 1 / 3.0);
            else
                fz = (float) ((k * zr + 16.0) / 116);

            _ls = (116 * fy) - 16;
            _as = 500 * (fx - fy);
            _bs = 200 * (fy - fz);

            int[] lab = new int[3];
            lab[0] = (int) (2.55 * _ls + .5);
            lab[1] = (int) (_as + .5);
            lab[2] = (int) (_bs + .5);
            return lab;
        }

        /**
 * Computes the difference between two RGB colors by converting them to the L*a*b scale and
 * comparing them using the CIE76 algorithm { http://en.wikipedia.org/wiki/Color_difference#CIE76}
 */
        public static double getColorDifference(Color a, Color b)
        {
            int r1 = a.R;
            int g1 = a.G;
            int b1 = a.B;
            int r2 = b.R;
            int g2 = b.G;
            int b2 = b.B;
            int[] lab1 = rgb2lab(r1, g1, b1);
            int[] lab2 = rgb2lab(r2, g2, b2);
            Console.WriteLine("lab1 = " + lab1[0] + ", " + lab1[1] + ", " + lab1[2]);
            Console.WriteLine("lab2 = " + lab2[0] + ", " + lab2[1] + ", " + lab2[2]);
            return Math.Sqrt(Math.Pow(lab2[0] - lab1[0], 2) + Math.Pow(lab2[1] - lab1[1], 2) +
                             Math.Pow(lab2[2] - lab1[2], 2));
        }
    }
}