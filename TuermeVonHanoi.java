public class TuermeVonHanoi{
    private Turm[] turme;
    private int anzahl;
    public TuermeVonHanoi(int anzahl){
        this.anzahl=anzahl;
        turme= new Turm[3];
        turme[0] = new Turm(anzahl);
        turme[0].setInhalt(anzahl);
        turme[1] = new Turm(anzahl);
        turme[2] = new Turm(anzahl);
    }
    public void hanoi(int anzahl, char start , char end, char leer) throws InterruptedException{
        if(anzahl==1){
            move(start, end);  
        }else{
            hanoi(anzahl-1, start, leer, end);
            move(start, end);  
            hanoi(anzahl-1, leer, end, start);
        }
    }  
    
    private void move(char start, char end) throws InterruptedException{
        int startIndex, endIndex;
        System.out.println(start + "  -»  " + end);
        if(start=='A'){
            startIndex=0;
            if(end=='B'){
                endIndex=1;
            }else{
                endIndex=2;
            }
        }
        else if(start=='B'){
            startIndex=1;
            if(end=='A'){
                endIndex=0;
            }else{
                endIndex=2;
            }
        }
       else{
            startIndex=2;
            if(end=='A'){
                endIndex=0;
            }else{
                endIndex=1;
            }
        }
        this.turme[endIndex].push(turme[startIndex].pop());
        viewTurme();
        Thread.sleep(4000);
    }
    
    private void viewTurme(){
        int counter = anzahl-1;
        for(int i =0; i< this.anzahl; i ++){
            for(Turm turm : turme){
                if(turm.turm[counter]!=null){
                    System.out.print(turm.turm[counter] + "   ");
                }else{
                    System.out.print("[   ]   ");
                }
            }
            counter--;
            System.out.println();
        }
        System.out.println("\n \n");
    }
    class Turm{
        public int idx;
        public String[] turm;
        public Turm(int anzahl){
            turm = new String[anzahl];
            this.idx=0;
        }
        public void setInhalt(int anzahl){
            int counter = anzahl;
            for(int i = 0 ; i<anzahl; i++){
                this.turm[i]="[ "+ counter+ " ]";
                counter--;
            }
            this.idx=anzahl;
        }
        public void push(String element){
            this.turm[this.idx++]=element;
        }

        public String pop(){
            String element=  this.turm[idx-1];
            this.turm[idx-1] = null;
            this.idx--;
            return element;
        }
    }

}