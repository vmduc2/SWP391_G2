using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace bai4_object
{
    internal class Student
    {
        //String Roll, Name, Gender, Address;
        //DateTime Dob;

        public String Roll { get; set; }
        public String Name { get; set; }
        public String Gender { get; set; }
        public String Address { get; set; }
        public DateTime Dob { get; set; }

        public Student()
        {
        }

        public Student(string roll, string name, string gender, string address, DateTime dob)
        {
            Roll = roll;
            Name = name;
            Gender = gender;
            Address = address;
            Dob = dob;
        }

        public void input()
        {
            Console.OutputEncoding = System.Text.Encoding.UTF8;
            Console.InputEncoding = System.Text.Encoding.UTF8;
            Console.Write("Nhập RoNumber : ");
            Roll = Console.ReadLine();
            Console.Write("Nhập tên : ");
            Name = Console.ReadLine();
            Console.Write("Nhập ngày sinh (dd/mm/yyyy): ");
            //DateOnly Dob = DateOnly.Parse(Console.ReadLine());
            Dob = DateTime.ParseExact(Console.ReadLine(), "dd/MM/yyyy", null);
            Console.Write("Nhập giới tính : ");
            Gender = Console.ReadLine();
            Console.Write("Nhập địa chỉ : ");
            Address = Console.ReadLine();

        }

        public void output()
        {
            Console.WriteLine("-----------------------------------------------------");
            Console.WriteLine("Roll Number : " + Roll);
            Console.WriteLine("Name : " + Name);
            Console.WriteLine("Date of birth : " + Dob);
            Console.WriteLine("Gender : " + Gender);
            Console.WriteLine("Address : " + Address);
            //Console.ReadKey();
        }


    }

}
