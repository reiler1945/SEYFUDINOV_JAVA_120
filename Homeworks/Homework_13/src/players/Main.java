package players;

public class Main {

    public static void main(String[] args) {
        Player marsel = new Player("Bob", 100);
        Player oleg = new Player("John", 100);
        UpgradedPlayer nadir =  new UpgradedPlayer("Max", 100);
        UpgradedPlayer medved = new UpgradedPlayer("Alex", 100);

        Player[] playersArray = {marsel, oleg, nadir, medved};

        for (int i = 0; i < playersArray.length; i++) {
            System.out.println(playersArray[i].getName() + ": очков = " + playersArray[i].getScore() + " health = " + playersArray[i].getHealth());
        }

        nadir.hit(marsel);

        nadir.addWeapon(new MachineGun("MG-42"));
        HotWeapon nadirMG = (HotWeapon)nadir.getCurrentWeapon();
        //System.out.println("Name of class = " + nadir.getCurrentWeapon().getClass().getSimpleName());
        nadirMG.reload();
        nadir.hit(medved);
        nadir.removeWeapon(nadirMG);

        //проверим вызов стратегий
        nadir.setStrategy(new StrategyCryOut());
        nadir.executeStrategy();
        nadir.setStrategy(new StrategySilent());
        nadir.executeStrategy();

        nadir.hit(medved);
        nadir.addWeapon(new Sword());
        
        //снова атакуем
        nadir.hit(oleg);
        nadir.hit(medved);
        
        //атакуем  
        oleg.hit(marsel);
        oleg.addEnemy(new Enemy());
        while (oleg.getHealth() > 30) {
            nadir.hit(oleg);
        }
        
        //отобразим конечные характеристики объектов
        for (int i = 0; i < playersArray.length; i++) {
            System.out.println(playersArray[i].getName() + ": очков = " + playersArray[i].getScore() + " health = " + playersArray[i].getHealth());
        }

    }
}