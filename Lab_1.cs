using System;
using System.Collections.Generic;

namespace SPP_Lab_1_2
{
    class Lab_1
    {
        static void Main(string[] args)
        {
            Dekanat dekanat = new Dekanat();

            Student student_1 = new Student("Иван","Иванович",1, dekanat, true, true, true);
            dekanat.RegisterObserver(student1);
            Student student_2 = new Student("Владимир", "Владимирович", 2, dekanat, true, true, false);
            Student student_3 = new Student("Кирилл", "Кириллович", 3, dekanat, true, false, false);
            Student student_4 = new Student("Вадим", "Вадимович", 4, dekanat, false, false, false);

            Console.WriteLine("Началась рассылка новостей.");
            dekanat.SendNews();
            Console.WriteLine("--------------------------");

            Console.WriteLine("Началась рассылка документов.");
            dekanat.SendDocuments();
            Console.WriteLine("--------------------------");

            Console.WriteLine("Начался сезон отчисления.");
            dekanat.Expel();
            
            Console.Read();
        }
    }

    interface IObservable
    {
        void RegisterObserver(IObserver o);
        void RemoveObserver(IObserver o);
        void NotifyObservers(List<IObserver> list);
    }

    class Dekanat : IObservable
    {
        DekanatInfo info;

        private List<IObserver> news_students;
        private List<IObserver> docs_students;
        private List<IObserver> bad_students;

        public Dekanat()
        {
            news_students = new List<IObserver>();
            docs_students = new List<IObserver>();
            bad_students = new List<IObserver>();

            info = new DekanatInfo();
        }

        public void RegisterObserver(IObserver o)
        {
            Student student = (Student)o;

            if (student.get_news)
                news_students.Add(o);

            if (student.get_docs)
                docs_students.Add(o);

            if (student.get_expel)
                bad_students.Add(o);
        }

        public void RemoveObserver(IObserver o)
        {
          
        }

        public void NotifyObservers(List<IObserver> list)
        {
            foreach (IObserver o in list)
            {
                o.Update(info);
            }
        }

        public void SendNews()
        {
            info.info = "новости";
            NotifyObservers(news_students);
        }

        public void SendDocuments()
        {
            info.info = "документы";
            NotifyObservers(docs_students);
        }

        public void Expel()
        {
            info.info = "новость об отчислении";
            NotifyObservers(bad_students);
        }

    }

    class DekanatInfo
    {
        public string info;
    }

    interface IObserver
    {
        void Update(Object ob);
    } 

    class Student: IObserver
    {
        public string FirstName { get; }
        public string LastName { get; }
        public int  GroupNumber { get; }

        public bool get_news;
        public bool get_docs;
        public bool get_expel;

        //IObservable dekanat;

        public Student(string FirstName, string LastName, int GroupNumber, /*IObservable dekanat*/, bool news, bool docs, bool expel)
        {
            this.FirstName = FirstName;
            this.LastName = LastName;
            this.GroupNumber = GroupNumber;
        
            get_news = news;
            get_docs = docs;
            get_expel = expel;

            //this.dekanat = dekanat;
            //this.dekanat.RegisterObserver(this);
        }

        public void Update(Object obj)
        {
            DekanatInfo dekanatinfo = (DekanatInfo)obj;
            Console.WriteLine($"{FirstName} {LastName} {GroupNumber} получил {dekanatinfo.info}");
        }
    }


}
