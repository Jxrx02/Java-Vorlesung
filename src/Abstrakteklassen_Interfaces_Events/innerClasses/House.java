package Abstrakteklassen_Interfaces_Events.innerClasses;

public class House {

    String s = "House";
    class Room {
        String s = "Room";
        class Chair {
            String s = "Chair";
            void output () {

                System.out.println (s);
                System.out.println( this.s );
                System.out.println (Chair. this.s );
                System.out.println( Room.this.s );
                System.out.println (House.this.s );
            }
        }
    }
        public static void main(String args []){
                new House(). new Room(). new Chair().output();

        }
}
