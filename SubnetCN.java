import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SubnetCN{
    public static void main(String[] args) throws IOException {
        
        System.out.println("Enter IP:");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String ip = br.readLine();
        String checkclass = ip.substring(0,3);
        
        int cc = Integer.parseInt(checkclass);
        String mask = null;
        if(cc>0){
            if(cc<=127){
                mask = "255.0.0.0";
                System.out.println("class A IP Adress");
                System.out.println("Subnet Mask:\n" + mask);
            }
            if(cc>=128 && cc<=191){
                mask = "255.255.0.0";
                System.out.println("class B IP Address");
                System.out.println("Subnet Mask:\n" + mask);
            }
            if(cc>=192 && cc<=223){
                mask = "255.255.255.0";
                System.out.println("class C IP Address");
                System.out.println("Subnet Mask:\n" + mask);
            }
            if(cc>=224 && cc<=239){
                mask = "255.0.0.0";
                System.out.println("class D IP Address used for multicasting");
            }
            if(cc>=240 && cc<=254){
                mask = "255.0.0.0";
                System.out.println("class E IP Address used for experimental purposes");
            }
        }

        String networkAddr="";
        String lastAddr="";
        String[] ipAddrParts=ip.split("\\.");
        String[] maskParts=mask.split("\\.");

        for(int i=0;i<4;i++){
            int x= Integer.parseInt(ipAddrParts[i]);
            int y= Integer.parseInt(maskParts[i]);
            int z = x & y;
            networkAddr += z+".";
            int w = z|(y^255);
            lastAddr += w+".";
        }

        System.out.println("First Address:\n"+networkAddr);
        System.out.println("Last Address:\n"+lastAddr);
    }
}
