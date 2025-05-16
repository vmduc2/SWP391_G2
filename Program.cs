using System.Diagnostics;

namespace bai4_object
{
    internal class Program
    {
        public void Menu()
        {
            String choice;
            Console.OutputEncoding = System.Text.Encoding.UTF8;
            Console.InputEncoding = System.Text.Encoding.UTF8;
            Control control = new Control();
            while (true)
            {
                Console.WriteLine("Menu:");
                Console.WriteLine("1. Add student");
                Console.WriteLine("2. Show students");
                Console.WriteLine("3. Update name");
                Console.WriteLine("4. Remove student");
                Console.WriteLine("5. Exit");
                Console.Write("Your choice: ");
                choice = Console.ReadLine();

                switch (choice)
                {
                    case "1":
                        control.AddStudent();
                        break;
                    case "2":
                        control.ShowStudent();
                        break;
                    case "3":
                        control.UpdateName();
                        break;
                    case "4":
                        control.RemoveStudent();
                        break;
                    case "5":
                        return;
                    default:
                        Console.WriteLine("Lựa chọn không hợp lệ !");
                        break;
                }

            }


        }

        static void Main(string[] args)
        {

            Program program = new Program();
            program.Menu();
        }
    }
}
