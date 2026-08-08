// 811. Subdomain Visit Count

class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {

        Map<String, Integer> map = new HashMap<>();

        for (String str : cpdomains) {
            String[] parts = str.split(" ");

            int count = Integer.parseInt(parts[0]);
            String domain = parts[1];

            String[] subdomains = domain.split("\\.");

            String current = "";

            for (int i = subdomains.length - 1; i >= 0; i--) {

                if (current.isEmpty()) {
                    current = subdomains[i];
                } else {
                    current = subdomains[i] + "." + current;
                }

                map.put(current, map.getOrDefault(current, 0) + count);
            }
        }

        List<String> ans = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            ans.add(entry.getValue() + " " + entry.getKey());
        }

        return ans;
    }
}