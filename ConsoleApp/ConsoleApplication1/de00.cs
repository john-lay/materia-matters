namespace ConsoleApplication1
{
    using System;

    public class ColorConverter
    {
        public static double CalculateDE00(ColorRGB color1, ColorRGB color2)
        {
            double L1 = color1.Luminance();
            double L2 = color2.Luminance();
            double a1 = color1.Redness() - color2.Redness();
            double a2 = color1.Greenness() - color2.Greenness();
            double b1 = color1.Blueness() - color2.Blueness();

            double C1 = Math.Sqrt(a1 * a1 + a2 * a2 + b1 * b1);
            double C2 = Math.Sqrt(color1.Redness() * color1.Redness() + color1.Greenness() * color1.Greenness() +
                                  color1.Blueness() * color1.Blueness());
            double dL = L2 - L1;
            double dC = C2 - C1;

            double dH = Math.Sqrt(Math.Max(0, dC * dC - dL * dL - dC * dC));

            double SL = 1.0;
            double SC = 1.0 + 0.045 * C1;
            double SH = 1.0 + 0.015 * C1;

            double RT = -2.0 * Math.Sqrt(Math.Pow(C1, 7.0) / (Math.Pow(C1, 7.0) + Math.Pow(25.0, 7.0))) *
                        Math.Sin((60.0 * Math.Exp(-Math.Pow((dH - 275.0) / 25.0, 2.0))) * Math.PI / 180.0);

            double dE00 = Math.Sqrt(Math.Pow(dL / SL, 2.0) + Math.Pow(dC / SC, 2.0) + Math.Pow(dH / SH, 2.0) +
                                    RT * (dC / SC) * (dH / SH));

            return dE00;
        }
    }

    public class ColorRGB
    {
        private int R { get; }
        private int G { get; }
        private int B { get; }

        public ColorRGB(int r, int g, int b)
        {
            R = r;
            G = g;
            B = b;
        }

        public double Luminance()
        {
            return 0.299 * R + 0.587 * G + 0.114 * B;
        }

        public double Redness()
        {
            return 0.436 * R - 0.289 * G - 0.147 * B;
        }

        public double Greenness()
        {
            return -0.168 * R + 0.686 * G - 0.118 * B;
        }

        public double Blueness()
        {
            return -0.03 * R - 0.143 * G + 0.823 * B;
        }
    }

    public class Program
    {
        public static void Main(string[] args)
        {
            // Example usage
            ColorRGB color1 = new ColorRGB(255, 0, 0); // Red
            ColorRGB color2 = new ColorRGB(0, 255, 0); // Green
            ColorRGB color3 = new ColorRGB(0, 0, 255); // Blue
            ColorRGB color4 = new ColorRGB(255, 255, 0); // Yellow
            ColorRGB color5 = new ColorRGB(10, 10, 255); // Bluish

            double dE00 = ColorConverter.CalculateDE00(color3, color5);
            Console.WriteLine($"dE00: {dE00}");
        }
    }
}