public class RPS {
    public static boolean RockPaperScissors(String x) {
        System.out.println("Schere, Stein, Papier!\n"+
                "Optionen: Schere, Stein, Papier");
        double rand = Math.random();
        x.trim();
        if(!x.equalsIgnoreCase("papier")&&!x.equalsIgnoreCase("schere")&&!x.equalsIgnoreCase("stein")){
            System.out.println("Falsche Eingabe!\n");
            return RPS.RockPaperScissors(Read.read());
        }
        if(rand < 0.3){     //Stein
            System.out.println("Ich wähle Stein!");
            if(x.toLowerCase().equals("papier")){
                return true;
            }else if(x.toLowerCase().equals("schere")){
                return false;
            }else{
                System.out.println("Ausgleich! Noch einmal!");
                x=Read.read();
                return RPS.RockPaperScissors(x);
            }
        }else if(rand < 0.6){   //Papier
            System.out.println("Ich wähle Papier!");
            if(x.toLowerCase().equals("stein")){
                return true;
            }else if(x.toLowerCase().equals("schere")){
                return false;
            }else{
                System.out.println("Ausgleich! Noch einmal!");
                x=Read.read();
                return RPS.RockPaperScissors(x);
            }
        }else if(rand<1){      //Schere
            System.out.println("Ich wähle Schere!");
            if(x.toLowerCase().equals("papier")){
                return true;
            }else if(x.toLowerCase().equals("stein")){
                return false;
            }else{
                System.out.println("Ausgleich! Noch einmal!");
                x=Read.read();
                return RPS.RockPaperScissors(x);
            }
        }
        return false;
    }
}
