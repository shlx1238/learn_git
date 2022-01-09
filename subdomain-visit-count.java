class Solution {

    public List<String> subdomainVisits(String[] cpdomains) {
        /**
         * 复杂度分析：设cpdomains的长度为n，则首先需要遍历cpdomains，分别统计不同域名的访问次数
         * 由于cpdomains的每个元素中可能包含多个域名，因此第一部分至少需要进行n次循环，至多进行k*n次循环，k为小于50的常数（因为cpdomains的每个元素长度小于100）
         * 第二部分需要进行的循环次数小于等于第一次
         * 综上，时间复杂度为O(n)
         */
        HashMap<String, String> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        
        // 第一部分，分别统计不同域名的访问次数
        for (int i = 0; i < cpdomains.length; i++) {
            String[] s = cpdomains[i].split(" ");
            String[] d = s[1].split("\\.");
            String temp = d[d.length-1];

            for (int j = d.length-1; j >= 0; j--) {
                if (j < d.length-1) {
                    temp = d[j] + "." + temp;
                }

                if (map.containsKey(temp)) {
                    map.put(temp, Integer.parseInt(map.get(temp)) + Integer.parseInt(s[0]) + ""); 
                } else {
                    map.put(temp, s[0]);
                }
            }

        }

        // 第二部分，将存储于HashMap中的结果进行合成
        for (String key : map.keySet()) {
            list.add(map.get(key) + " " + key);
        }

        return list;
    }
}