/*
Задача:
Ориентируясь на # 17. Inheritance, в частности иерархию Player-UpgradedPlayer реализовать:
иерархиую оружия

возможность добавления любого (из созданных) оружия в UpgradedPlayer

Каждое оружие должно иметь урон

Каждое оружие должно иметь бонус

Вопросы:
1. как называть пакеты, если они состоят из 2 и более слов?
2. Задание 12: как реализовать метод Tv.setChannels()? Создавать копию массива массивов объектов?
3. Singleton: отличия между экземпляр создавать через static() и через отдельный public static getInstance() 
*/
package players;
public class Main {

    public static void main(String[] args) {
        Player marsel = new Player("Марсель", 100);
        Player oleg = new Player("Олег", 100);
        UpgradedPlayer nadir =  new UpgradedPlayer("Надир", 100);
        UpgradedPlayer medved = new UpgradedPlayer("Медведь", 100);
        
        //массив объектов "Players"
        Player[] playersArray = {marsel, oleg, nadir, medved};
        
        //отобразим начальные характеристики объектов
        for (int i = 0; i < playersArray.length; i++) {
            System.out.println(playersArray[i].getName() + ": очков = " + playersArray[i].getScore() + " health = " + playersArray[i].getHealth());
        }
        
        //атака, если нет Weapon у объекта, то будет вызван метод Players.hit(...)
        nadir.hit(marsel);
        
        //дадим оружие UpgradedPlayer 
        nadir.setWeapon(new MachineGun("MG-42"));
        
        
        HotWeapon hotWeapon = (HotWeapon) nadir.getWeapon();
        hotWeapon.reloadFrom(nadir);
        nadir.hit(medved);
        nadir.setWeapon(new Sword());
        nadir.hit(oleg);
        nadir.hit(medved);
        oleg.hit(marsel);
        for (int i = 0; i < playersArray.length; i++) {
            System.out.println(playersArray[i].getName() + ": очков = " + playersArray[i].getScore() + " health = " + playersArray[i].getHealth());
        }

    }
}
