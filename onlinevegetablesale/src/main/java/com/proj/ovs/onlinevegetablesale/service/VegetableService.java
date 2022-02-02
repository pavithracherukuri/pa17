package com.proj.ovs.onlinevegetablesale.service;



	import java.util.List;
	import java.util.Optional;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;

	import com.proj.ovs.onlinevegetablesale.entity.Address;
	import com.proj.ovs.onlinevegetablesale.entity.Vegetable;
	import com.proj.ovs.onlinevegetablesale.repos.VegetableRepo;
	@Service
	public class VegetableService {
	@Autowired
	VegetableRepo  vegetableRepo;
		public Vegetable createVegetable(Vegetable vegetable) {
			
			return vegetableRepo.save(vegetable)    ;
		}

		public List<Vegetable> getVegetable() {
			// TODO Auto-generated method stub
			return  vegetableRepo.findAll() ;
		}

		public boolean deleteAllVegetable() {
			// TODO Auto-generated method stub
			 try {
				 vegetableRepo.deleteAll();
			 }
			 catch(Exception e)
			 {
				 return false;
			 }
			 return true;
		}

		public Vegetable updateVegetable(int vegId, Vegetable obj) {
			// TODO Auto-generated method stub
			 Optional<Vegetable> vegetableContainer=vegetableRepo.findById(vegId);
			 if(vegetableContainer.isPresent())
			 {
				 Vegetable oldObj=vegetableContainer.get();
				 oldObj.setName(obj.getName());
				 oldObj.setType(obj.getType());
				 oldObj.setPrice(obj.getPrice());
				 oldObj.setQuantity(obj.getQuantity());
				 System.out.println("successfully updated");
				 return vegetableRepo.saveAndFlush(oldObj);
			 }
			 System.out.println("No object found with this vegetable id");
			return obj;
		}


	}

