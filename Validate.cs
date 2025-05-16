using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Xml.Linq;
using static System.Runtime.InteropServices.JavaScript.JSType;

namespace bai4_object
{
    internal class Validate
    {
        private List<Student> list = new List<Student>();
        public string GetValidInput(string prompt, Func<string, bool> validate, string errorMessage)
        {
            string input;
            do
            {
                Console.Write(prompt);
                input = Console.ReadLine().Trim();
                if (!validate(input))
                    Console.WriteLine($"❌ {errorMessage}");
            } while (!validate(input));
            return input;
        }
        public bool IsValidRoll(string roll)
        {
            return !string.IsNullOrWhiteSpace(roll) && roll.Length >= 3 && roll.Length <= 10;
        }

        public bool IsValidName(string name)
        {
            return !string.IsNullOrWhiteSpace(name);
        }
        public bool IsValidDate(string dob)
        {
            return DateTime.TryParseExact(dob, "dd/MM/yyyy", null, System.Globalization.DateTimeStyles.None, out _);
        }
        public bool IsValidGender(string gender)
        {
            return !string.IsNullOrWhiteSpace(gender) && (string.Equals("man", gender, StringComparison.OrdinalIgnoreCase) || string.Equals("girl", gender, StringComparison.OrdinalIgnoreCase));
        }
        public bool IsValidAddress(string address)
        {
            return !string.IsNullOrWhiteSpace(address);
        }
        public bool IsValidNumber(string number) {
            return !string.IsNullOrWhiteSpace(number) && int.TryParse(number, out int result) && result > 0 && result < 30;
        }
        public bool IsExistRoll(string roll )
        {
            return !string.IsNullOrWhiteSpace(roll) && (list.Count == 0 || !list.Any(s => s.Roll.Equals(roll, StringComparison.OrdinalIgnoreCase)));
        }
    }
}
