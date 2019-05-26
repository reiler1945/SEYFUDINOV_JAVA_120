/*
Задача:
Ориентируясь на # 17. Inheritance, в частности иерархию Player-UpgradedPlayer реализовать:
иерархиую оружия

возможность добавления любого (из созданных) оружия в UpgradedPlayer

Каждое оружие должно иметь урон

Каждое оружие должно иметь бонус

Создать класс Enemy, который наблюдает за игроком. Если у игрока меньше 30% жизни, то Enemy начинает на него нападать.
(Сделать с помощью Observer).

Применить паттерн Strategy в проекте с игроком, врагом и оружением.
(попробовать применить для выбора метода атаки у Player)
*/
package players;
public class Main {

    public static void main(String[] args) {
        Player marsel = new Player("Марсель", 100);
        Player oleg = new Player("Олег", 100);
        UpgradedPlayer nadir =  new UpgradedPlayer("Надир", 100);
        UpgradedPlayer medved = new UpgradedPlayer("Медведь", 100);

        Player[] playersArray = {marsel, oleg, nadir, medved};

        for (int i = 0; i < playersArray.length; i++) {
            System.out.println(playersArray[i].getName() + ": очков = " + playersArray[i].getScore() + " health = " + playersArray[i].getHealth());
        }

        nadir.hit(marsel);

        nadir.addWeapon(new MachineGun("MG-42"));
        HotWeapon nadirMG = (HotWeapon)nadir.getCurretWeapon();
        System.out.println("Имя класса = " + nadir.getCurretWeapon().getClass().getName());
        nadirMG.reload();
        nadir.hit(medved);
        nadir.removeWeapon(0);
        nadir.hit(medved);
        nadir.addWeapon(new Sword());
        
        //снова атакуем
        nadir.hit(oleg);
        nadir.hit(medved);
        
        //атакуем  
        oleg.hit(marsel);
        oleg.addObserver(new Enemy());
        while (oleg.getHealth() > 30) {
            nadir.hit(oleg);
        }
        
        //отобразим конечные характеристики объектов
        for (int i = 0; i < playersArray.length; i++) {
            System.out.println(playersArray[i].getName() + ": очков = " + playersArray[i].getScore() + " health = " + playersArray[i].getHealth());
        }

    }
}
