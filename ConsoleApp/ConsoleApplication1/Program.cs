// using System;
// using System.Drawing;
// using System.IO;
// using System.Reflection;
//
// namespace ConsoleApplication1
// {
//     internal class Program
//     {
//         private static Image loadImage()
//         {
//             string currentDir = Path.GetDirectoryName(Assembly.GetExecutingAssembly().Location);
//             Console.WriteLine("current directory = " + currentDir);
//             string path = Path.Combine(currentDir, @"..\..\Assets\01-01.jpg");
//             Image i = Image.FromFile(path);
//             Console.WriteLine("image width = " + i.Width);
//             Console.WriteLine("image height = " + i.Height);
//
//             return i;
//         }
//
//         public static void Main(string[] args)
//         {
//             Image image = loadImage();
//             Bitmap resizedImage = new Bitmap(image, new Size(1, 1));
//             // ImageConverter imageConverter = new ImageConverter();
//             // byte[] xByte = (byte[]) imageConverter.ConvertTo(i, typeof(byte[]));
//             Color avColorFromImage = resizedImage.GetPixel(0, 0);
//             Console.WriteLine("av. color = " + avColorFromImage);
//             Color fireMateria = ColorTranslator.FromHtml("#ff3030");
//             Console.WriteLine("fire color = " + fireMateria);
//
//             Double deltaE = ColorUtil.getColorDifference(avColorFromImage, fireMateria);
//             Console.WriteLine("delta E = " + deltaE);
//             
//             Double equalTest = ColorUtil.getColorDifference(Color.Blue, Color.Blue);
//             Console.WriteLine("equal test = " + equalTest);
//             
//             Double oppositeTest = ColorUtil.getColorDifference(Color.Blue, Color.Yellow);
//             Console.WriteLine("opposite test = " + oppositeTest);
//             
//             Color closeBlue = ColorTranslator.FromHtml("#206fdf");
//             Double closeTest = ColorUtil.getColorDifference(Color.Blue, closeBlue);
//             Console.WriteLine("close test = " + closeTest);
//             
//             Console.ReadLine();
//         }
//     }
// }
