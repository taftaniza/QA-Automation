public class Main {

    public static void main(String[] args)
    {
        //If-else
        int score= 87;
        if(score >= 85){
            System.out.println("A, Excellent!");
        }
        else if(score >= 80){
                System.out.println("B, Well Done!");
        }
        else if(score >= 70) {
            System.out.println("C, Good Job!");
        }
        else if(score >= 60) {
            System.out.println("D, Better luck next time");
        }
        else {
            System.out.println("E, Don't give up!");
        }

        //Switch
        switch (score){
            case 85:
                System.out.println("A");
                case 80:
                    System.out.println("B");
                    case 70:
                        System.out.println("C");
                        case 60:
                            System.out.println("D");
            default: System.out.println("E");
        }

        //While Loop
        int i = 0;
        while(i<6){
            System.out.println(i);
            i++;
        }

        //For Loop
        for(int a=0;a<5;a++){
            System.out.println(a);
        }


        //Nested For Loop
        for(int j=0; j<3; j++){
            for(int k=1; k<=3; k++){
                System.out.print("*");
            }
            System.out.println();
        }

        //For-Each Loop
        int[] grades = {85, 80, 70, 60, 60};
        for(int x: grades){
            System.out.println(x);
        }

    }

}