using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Reflection;
using System.Runtime.CompilerServices;
using System.Text;
using System.Threading.Tasks;
using System.Xml.Linq;

namespace bai4_object
{
    internal class Control
    {

        List<Student> List = new List<Student>();
        Validate Validate = new Validate();
        public void AddStudent()
        {
            Console.OutputEncoding = System.Text.Encoding.UTF8;
            Console.InputEncoding = System.Text.Encoding.UTF8;
            int n = int.Parse(Validate.GetValidInput("Nhập số học sinh : ",Validate.IsValidNumber,"Chỉ nhập số nguyên lớn hơn 0 và bé hơn 30"));

            for (int i = 0; i < n; i++)
            {
                Console.OutputEncoding = System.Text.Encoding.UTF8;
                Console.InputEncoding = System.Text.Encoding.UTF8;
                String Roll;
                if (List.Count > 0)
                {
                     Roll = Validate.GetValidInput("Nhập RollNumber : ", Validate.IsExistRoll, "RollNumber existed !");
                }
                else { 
                     Roll = Validate.GetValidInput("Nhập RollNumber : ", Validate.IsValidRoll, "RollNumber không hợp lệ !");
                }

                    String Name = Validate.GetValidInput("Nhập tên : ", Validate.IsValidName, "Name không hợp lệ !");

                //DateOnly Dob = DateOnly.Parse(Console.ReadLine());
                DateTime Dob = DateTime.ParseExact(Validate.GetValidInput("Nhập ngày sinh (dd/mm/yyyy): ", Validate.IsValidDate, "Date of birth không hợp lệ!"), "dd/MM/yyyy", null);

                String Gender = Validate.GetValidInput("Nhập giới tính : ", Validate.IsValidGender, "Gender không hợp lệ !");

                String Address = Validate.GetValidInput("Nhập địa chỉ : ", Validate.IsValidAddress, "Địa chỉ không hợp lệ!");

                List.Add(new Student(Roll, Name, Gender, Address, Dob));
                Console.WriteLine("Add successfull!");

            }
        }

        public void ShowStudent()
        {
            Console.WriteLine("List Student : ");
            for (int i = 0; i < List.Count; i++)
            {
                List[i].output();
            }
            Console.WriteLine("===============");
        }

        public void UpdateName()
        {
            bool check = false;
            Console.WriteLine("Update Student");
            Console.Write("Nhập RollNumber : ");
            String Roll = Console.ReadLine();
            foreach (Student student in List)
            {
                if (string.Equals(student.Roll, Roll, StringComparison.OrdinalIgnoreCase))
                {
                    Console.WriteLine("Name : "+ student.Name);
                    student.Name = Validate.GetValidInput("Tên mới : ", Validate.IsValidName, "Tên không hợp lệ!");
                    Console.WriteLine("Update name successfull!");
                    student.output();
                    check = true;
                    break;
                }
            }
            if (!check)
            {
                Console.WriteLine("RollNumber do not exist!");
            }
            Console.WriteLine("===============");
        }
        public void RemoveStudent()
        {
            bool check = false;
            Console.WriteLine("Remove Student");
            Console.Write("Nhập RollNumber : ");
            String Roll = Console.ReadLine();
            foreach (Student student in List)
            {
                if (string.Equals(student.Roll, Roll, StringComparison.OrdinalIgnoreCase))
                {
                    List.Remove(student);
                    Console.WriteLine("Remove successfull!");
                    check = true;
                    break;
                }
            }
            if (!check)
            {
                Console.WriteLine("RollNumber do not exist!");
                return;
            }
            Console.WriteLine("List Student : ");
            for (int i = 0; i < List.Count; i++)
            {
                List[i].output();
            }


            Console.WriteLine("===============");
        }
    }
}
