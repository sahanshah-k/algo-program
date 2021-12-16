class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pt = new ArrayList<>();
        pt.add(new ArrayList<Integer>() {{
            add(1);        
        }});
        if (numRows == 1) {
            return pt;
        }
        pt.add(new ArrayList<Integer>() {{
            add(1);        
            add(1);        
        }});
        if (numRows == 2) {
            return pt;
        }
        for (int i = 1; i < numRows - 1; i ++) {
            int tempSize = pt.get(i).size();
            List<Integer> tempList = new ArrayList<>();
            tempList.add(pt.get(i).get(0));
            for (int j = 0; j < pt.get(i).size() - 1; j ++) {
                tempList.add(
                    pt.get(i).get(j) + pt.get(i).get(j + 1)
                );
            }
            tempList.add(pt.get(i).get(tempSize - 1));
            pt.add(tempList);
        }
        return pt;
    }
}
