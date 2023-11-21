public class Main {
    public static void main(String args[]){
        String str = "xpix";

        String x = changePi(str);
    }
    public String changePi(String str) {
        if(str.length() == 1 || str.length() == 0)
          return str;
        else if(str.substring(0,2) == "pi")
          return "3.14" + changePi(str.substring(2));
        else
          return str.substring(0,1) + changePi(str.substring(1));
      }
    }

      
    

