public class Test3Quit{
	public static void main(String args[]){
		KidCircle kc = new KidCircle(500);
		int countNum = 0;
		Kid k = kc.first;
		while(kc.count > 1){
			countNum ++;
			if(countNum == 3){
				kc.delete(k);
				countNum = 0;
			}
			k = k.right;
		}
		System.out.println(kc.first.id);
	}
}

class Kid{
	int id;
	Kid left;
	Kid right;
}

class KidCircle{
	int count = 0;
	Kid first;
	Kid last;
	
	KidCircle(int n){
		for(int i = 0; i < n; i++){
			add();
		}
	}
	
	void add(){
		Kid k = new Kid();
		k.id = count;
		if(count <= 0){
			first = k;
			last = k;
			k.left = k;
			k.right = k;
		}else{
			last.right = k;
			k.right = first;
			k.left = last;
			first.left = k;
			last = k;
		}
		count++;
	}
	
	void delete(Kid k){
		if(count <= 0){
			System.out.println("no kids to delete!");
		}else if(count == 1){
			first = last = null;
		}else{
			k.left.right = k.right;
			k.right.left = k.left;
			
			//这是你忘记的地方，而这，使得输出结果为0
			if(k == last){
				last = k.left;
			}else if(k == first){
				first = k.right;
			}
		}
		count--;
	}
}