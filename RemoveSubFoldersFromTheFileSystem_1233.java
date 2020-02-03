class Solution {
    public List<String> removeSubfolders(String[] folder) {
        int length = folder.length;
        Arrays.sort(folder);

        List<String> result = new ArrayList<>();
        String base = folder[0];
        result.add(base);
        for(int i=1; i<length; i++){
        	String current = folder[i];
        	if(isSubfolder(base, current)){
        		continue;
        	}
        	base = current;
        	result.add(base);
        }
        return result;
    }

    private boolean isSubfolder(String base, String current){
    	if(current.length() <= base.length()){
    		return false;
    	}
    	if(current.charAt(base.length()) != '/'){
    		return false;
    	}
    	return current.startsWith(base);
    }
}