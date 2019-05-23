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
4. как переносить условия в HotWeapo.reload()?
5. что на практике программисты используют, чтобы не терять связь, к примеру, с protected полями из класса предка, работая с классом потомком? 
6. рекомендации по комментариям
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
        
        //НАДИР: атака, если нет Weapon у объекта, то будет вызван метод Players.hit(...)
        nadir.hit(marsel);
        
        //НАДИР: дадим огнестрельное оружие UpgradedPlayer 
        nadir.setWeapon(new MachineGun("MG-42"));
        
        //НАДИР: перезарядим огнестрельное оружие, так как по умолчанию оно не заряжено
        HotWeapon hotWeapon = (HotWeapon) nadir.getWeapon();
        hotWeapon.reload();
        
        //НАДИР: атакуем уже с помощью оружия
        nadir.hit(medved);
        
        //НАДИР: поменяем оружие на меч
        nadir.setWeapon(new Sword());
        
        //НАДИР: снова атакуем
        nadir.hit(oleg);
        nadir.hit(medved);
        
        //ОЛЕГ: атакуем  
        oleg.hit(marsel);
        
        //отобразим конечные характеристики объектов
        for (int i = 0; i < playersArray.length; i++) {
            System.out.println(playersArray[i].getName() + ": очков = " + playersArray[i].getScore() + " health = " + playersArray[i].getHealth());
        }

    }
}
