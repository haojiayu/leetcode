package subdomainVisits;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubdomainVisits {

    public static List<String> subdomainVisits(String[] cpdomains) {
        List<String> result = new ArrayList<>();
        Map<String,Integer> data = new HashMap<>();
        //通过 拆分
        for (String cpdomain : cpdomains) {
            String[] strings = cpdomain.split(" ");
            int count = Integer.parseInt(strings[0]);
            String domain = strings[1];
            int start ;
            do {
                start = domain.indexOf(".");
                Integer subCount = data.get(domain);
                if(subCount==null){
                    data.put(domain,count);
                } else {
                    subCount = subCount+count;
                    data.put(domain,subCount);
                }
                domain = domain.substring(start+1);
            }while (start>0);
        }
        data.keySet().forEach(a-> result.add(data.get(a)+" "+a));
        return result;
    }

    public static void main(String[] args) {
        String[] strings = new String[]{
                "900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"};

        System.out.println(subdomainVisits(strings));
    }

}
