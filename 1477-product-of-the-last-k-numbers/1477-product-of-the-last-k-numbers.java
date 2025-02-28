class ProductOfNumbers {

    List<Integer> prefixProd;

    public ProductOfNumbers() {
        prefixProd = new ArrayList<>();
    }
    
    public void add(int num) {
        if(num == 0) {
            prefixProd.clear();
        } else if (prefixProd.size() == 0) {
            prefixProd.add(num);
        } else {
            prefixProd.add(prefixProd.get(prefixProd.size()-1) * num);
        }
    }
    
    public int getProduct(int k) {
        if (k > prefixProd.size()) {
            return 0;
        } else if (k == prefixProd.size()) {
            return prefixProd.get(prefixProd.size() - 1);
        }
        return prefixProd.get(prefixProd.size() - 1) / prefixProd.get(prefixProd.size() - k-1);
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */