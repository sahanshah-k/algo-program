class TimeMap {
    HashMap<String, HashMap<Integer, String>> map;
    ArrayList<Integer> timeList;
    
    public TimeMap() {
        this.map = new HashMap<>();
        this.timeList = new ArrayList<>();
    }
    
    public void set(String key, String value, int timestamp) {
        HashMap<Integer, String> sub = this.map.getOrDefault(key, new HashMap<Integer, String>());
        sub.put(timestamp, value);
        this.map.put(key, sub);
        this.timeList.add(timestamp);
    }
    
    int binarySearch(ArrayList<Integer> arr, int x) {
        int left = 0, right = arr.size() - 1;   
        int mid = 0;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (arr.get(mid) == x)
                return mid;
            if (arr.get(mid) < x)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return mid;
    }
    
    public String get(String key, int timestamp) {
        if (this.map.containsKey(key)) {
            if (this.map.get(key).containsKey(timestamp)) {
                return this.map.get(key).get(timestamp);
            } else {
                for (int i = timestamp; i >= 1; i --) {
                    if (this.map.get(key).containsKey(i)) {
                        return this.map.get(key).get(i);
                    }
                }
                return "";
            }
        } else {
            return "";
        }
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */