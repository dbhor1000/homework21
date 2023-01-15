import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {



        //Водители, участвующие в гонках

        DriverCategoryB driver1 = new DriverCategoryB("Иван", true, 8, "B");
        DriverCategoryB driver2 = new DriverCategoryB("Сергей", true, 5, "С");
        DriverCategoryB driver3 = new DriverCategoryB("Артур", true, 6, "B");
        DriverCategoryB driver4 = new DriverCategoryB("Арсен", true, 3, "B");

        DriverCategoryC driver5 = new DriverCategoryC("Фёдор", true, 3, "D");
        DriverCategoryC driver6 = new DriverCategoryC("Михаэль", true, 5, "C");
        DriverCategoryC driver7 = new DriverCategoryC("Александр", true, 7, "C");
        DriverCategoryC driver8 = new DriverCategoryC("Дмитрий", true, 7, "C");

        DriverCategoryD driver9 = new DriverCategoryD("Пётр", true, 10, "D");
        DriverCategoryD driver10 = new DriverCategoryD("Святослав", true, 12, "D");
        DriverCategoryD driver11 = new DriverCategoryD("Денис", true, 8, "D");
        DriverCategoryD driver12 = new DriverCategoryD("Арсений", true, 13, "C");

        //Транспортные средства, участвующие в гонках

        Car car1 = new Car("Форд", "Фокус", 1.6, driver1);
        Car car2 = new Car("Форд", "Мустанг", 2.6, driver2, Car.CarTypes.Универсал);
        Car car3 = new Car("Ауди", "A8", 1.6, driver3, Car.CarTypes.Внедорожник);
        Car car4 = new Car("Лада", "Калина", 3.4, driver4, Car.CarTypes.Кроссовер);


        Truck truck1 = new Truck("Скания", "Model 1", 4.6, driver5, Truck.TruckTypes.N2);
        Truck truck2 = new Truck("Джип", "Гладиатор", 5.6, driver6, Truck.TruckTypes.N1);
        Truck truck3 = new Truck("Тойота", "Такома", 4.0, driver7);
        Truck truck4 = new Truck("Шевроле", "Колорадо", 4.2, driver8);


        Bus bus1 = new Bus("Вольво", "B11R", 3.6, driver9, Bus.BusTypes.Средняя);
        Bus bus2 = new Bus("MAN", "Bus1", 3.7, driver10);
        Bus bus3 = new Bus("Marcopolo", "Multego", 3.6, driver11);
        Bus bus4 = new Bus("King Long", "XMQ6996Y", 4.0, driver12);


        //Вывод всех имеющихся типов различных авто:

        Car.CarTypes.carTypesToString();
        Bus.BusTypes.busTypesToString();
        Truck.TruckTypes.truckTypesToString();

        //Вывод типов транспортных средств по интересующим критериям:

        car1.printType(); //Тип не указан
        bus1.printType();
        truck1.printType();
        car2.printType();


        //ДЗ от 28 декабря. С Новым Годом! Добавлены геттеры в правах всех трёх категория, класс для ошибки при проверке водительских прав машин и грузовиков.
        //В класс transport добавлен абстрактный метод undergoDiagnostic, переопределён в классе для машин и грузовиков. В классе мейн добавлена проверка с помощью
        //добавленного метода и обработка исключений.

        try {
            car1.undergoDiagnostic();       //Указан верный тип прав.
        } catch (DriverLicenseException e) {
            System.out.println(e.getMessage());
            System.out.println("Необходимо указать тип прав.");
        }

        System.out.println();

        try {
            truck1.undergoDiagnostic();     //Тип прав указан ошибочно.
        } catch (DriverLicenseException e) {
            System.out.println(e.getMessage());
            System.out.println("Необходимо указать тип прав.");
        }

        bus1.undergoDiagnostic();       //Автобусам не нужна диагностика, сообщение не выводится.

        System.out.println();

        try {
            car2.undergoDiagnostic();       //Тип прав указан ошибочно.
        } catch (DriverLicenseException e) {
            System.out.println(e.getMessage());
            System.out.println("Необходимо указать тип прав.");
        }

        System.out.println();

        //ДЗ от 9 января. --->
        //C автомобилем могут работать до двух механников одновременно, с грузовиками и автобусами до 3, это прописано в методах класса Mechanic
        //Метод интерфейся DriverAndCarInformation теперь работает по-другому и выводит механиков, обслуживающих автомобиль.
        //Подклассам класса Transport был добавлен список в качестве поля, для учёта механиков.


        Mechanic mechanic1 = new Mechanic("Алексей Петрович", "Автомобильная компания 1", true, true, true);
        Mechanic mechanic2 = new Mechanic("Антон Игнатьевич", "Автомобильная компания 1", false, true, true);
        Mechanic mechanic3 = new Mechanic("Сергей Иванович", "Автомобильная компания 1", false, true, true);
        Mechanic mechanic4 = new Mechanic("Иван Евгеньевич", "Автомобильная компания 2", true, false, true);
        Mechanic mechanic5 = new Mechanic("Артур Денисович", "Автомобильная компания 2", false, false, true);
        Mechanic mechanic6 = new Mechanic("Денис Артурович", "Автомобильная компания 2", true, true, true);
        Mechanic mechanic7 = new Mechanic("Дмитрий Борисович", "Автомобильная компания 2", false, true, true);
        Mechanic mechanic8 = new Mechanic("Пётр Андреевич", "Автомобильная компания 2", true, false, true);
        Mechanic mechanic9 = new Mechanic("Семён Сергеевич", "Автомобильная компания 2", false, true, false);
        Mechanic mechanic10 = new Mechanic("Владимир Владимирович", "Автомобильная компания 2", false, true, true);
        Mechanic mechanic11 = new Mechanic("Александр Сергеевич", "Автомобильная компания 2", true, true, false);
        Mechanic mechanic12 = new Mechanic("Дмитрий Иванивич", "Автомобильная компания 2", false, true, true);



        //ДЗ от 11 января. --->
        //Внесены изменения по сравнению с версией от 9 января. Теперь объекты классов Car, Truck, Vehicle имеют hashMap mechanics в качестве поле вместо списка
        //ArrayList. Соответственно, по техническим причинам, теперь с каждым транспортным средством может работь только 1 механик. При попытке назначить одного
        //и того же механика на два транспортных средства, появляется стандартное сообщение, что это невозможны. Это сделано при помощи добавления поля atWork в
        //класс Mechanics. Конструкционно, дубликатов в Мапах, относящихся к объектам быть не может (т.к. в качестве ключа выступает само транспортное средство).
        //Метод который относится к interface DriverAndCarInformation более не задействован, теперь вместо него очень похожая копия, только
        //с параметром(транспортное средство) requestDriverAndCarInformationMap.
        //!!Была идея добавить класс для генерации объектов с одним полем hashMap(MapOfMechanics) чтобы методы класса Mechanic одновременно добавляли значения и в него.
        //А потом произвести итерацию по этому мапу. Это не получилось, так как метод, указанный в конспекте никак не хочет работать. Было бы интересно разобраться :)
        //Это как раз подошло бы под задание: "Перепишите приложение: если в случае ошибки какой-либо из объектов будет занесен в базу два раза,
        //то в консоль выведется информация без повторов."

        MapOfMechanics map = new MapOfMechanics(); //генерация объекта Мапа механиков

        mechanic1.engageTechnicalService(car1, mechanic1);  //Механик обслуживает автомобиль 1
        mechanic1.engageTechnicalService(car2, mechanic1);  //Механик не может обслуживать два автомобиля сразу
        mechanic2.engageTechnicalService(car1, mechanic2); //Этот автомобиль чинит другой механик
        mechanic3.engageTechnicalService(bus1, mechanic3); //Механик чинит автобус
        mechanic4.engageTechnicalService(truck1, mechanic4); //Механик чинит грузовик
        mechanic5.engageTechnicalService(truck1, mechanic5);  //Этот грузовик чинит другой механик.
        mechanic6.engageTechnicalService(truck1, mechanic6);  //Этот грузовик чинит другой механик.

        //Вызываем информацию о транспортном средстве, водителе и механиках
        car1.requestDriverAndCarInformationMap(car1);
        truck1.requestDriverAndCarInformationMap(truck1);
        bus1.requestDriverAndCarInformationMap(bus1);

        //Вместо списка транспортных средств теперь мап механиков, а транспортные средства в роли ключей.
        //При выводе механика по транспортному средству отображается имя или null.
        HashMap<Transport, Mechanic> raceParticipants = new HashMap<>();
        raceParticipants.put(car1, car1.mechanics.get(car1));
        raceParticipants.put(car2, car1.mechanics.get(car2));
        raceParticipants.put(car3, car1.mechanics.get(car3));
        raceParticipants.put(car4, car1.mechanics.get(car4));
        raceParticipants.put(truck1, truck1.mechanics.get(truck1));
        raceParticipants.put(truck2, truck2.mechanics.get(truck2));
        raceParticipants.put(truck3, truck3.mechanics.get(truck3));
        raceParticipants.put(truck4, truck4.mechanics.get(truck4));
        raceParticipants.put(bus1, bus1.mechanics.get(bus1));
        raceParticipants.put(bus2, bus2.mechanics.get(bus2));
        raceParticipants.put(bus3, bus3.mechanics.get(bus3));
        raceParticipants.put(bus4, bus4.mechanics.get(bus4));

        System.out.println(raceParticipants.get(truck1));
        System.out.println(raceParticipants.get(car3));











    }
}