public class Test0 {
    public static <AnyType extends Comparable<? super AnyType>>
    void insertionSort(AnyType[] a){
        for(int i=1;i<a.length;i++){
            AnyType temp = a[i];
            int j = i-1;
            while(j>=0){
                if(a[j].compareTo(temp)>0){
                    a[j+1]=a[j];
                    j--;
                }
                else
                    break;
            }
            a[j+1] = temp;
        }
    }

    public static <AnyType extends Comparable<? super AnyType>>
    void mergeSort( AnyType [ ] a ){
        AnyType [ ] temp = (AnyType[]) new Comparable[ a.length ];
        mergeSort(a,0,a.length-1,temp);
    }

    private static <AnyType extends Comparable<? super AnyType>>
    void mergeSort( AnyType [ ] a ,int left,int right,AnyType[] temp){
        int mid = (left+right)/2;
        if(left<right){
            mergeSort(a,left,mid,temp);
            mergeSort(a,mid+1,right,temp);
            merge(a,left,mid,right,temp);
        }
    }

    private static <AnyType extends Comparable<? super AnyType>>
    void merge( AnyType [ ] a ,int left,int mid,int right,AnyType[] temp){
        int lpos = left;
        int mpos = mid+1;
        int tpos = left;
        while(lpos<=mid && mpos<=right){
            if(a[lpos].compareTo(a[mpos])<=0)
                temp[tpos++] = a[lpos++];
            else
                temp[tpos++] = a[mpos++];
        }
        while(lpos<=mid)
            temp[tpos++]=a[lpos++];
        while(mpos<=right)
            temp[tpos++]=a[mpos++];
        for(int i= left;i<=right;i++){
            a[i]=temp[i];
        }
    }

    public static void main(String[] args){
        /*
        Integer[] array = {132,32,674,31,22,674,994,1,5,66};
        insertionSort(array);
        for (Integer as: array)
            System.out.print(as+" ");
        System.out.println("");
        */
        Integer[] array2 = {132,32,674,31,22,674,994,1,5,66};
        mergeSort(array2);
        for (Integer as: array2)
            System.out.print(as+" ");
    }
}
