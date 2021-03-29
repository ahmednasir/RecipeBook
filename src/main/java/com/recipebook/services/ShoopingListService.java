package com.recipebook.services;

import com.recipebook.entity.ResponseBody;
import com.recipebook.entity.ShoppingList;
import com.recipebook.repository.ShoppingListRepository;
import com.recipebook.utils.BuildResponseMesage;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoopingListService {

    @Autowired
    private ShoppingListRepository shoppingListRepository;

    private BuildResponseMesage responseMessage;

    public List<ShoppingList> getAllShoppingList(){
        try{
            return shoppingListRepository.findAll();
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
    }

    public ResponseBody addToList(ShoppingList shoppingList){
        try{
            shoppingListRepository.save(shoppingList);
            return responseMessage.getSuccessMessage();
        }catch (Exception e){
            System.out.println(e);
            return responseMessage.getInternalServerErrorMesage();
        }
    }

    public ResponseBody updateList(int id, ShoppingList newList){
        try{
            ShoppingList existingList = shoppingListRepository.findById(id).orElse(null);

            if(existingList == null) throw new Exception("No Object found");

            BeanUtils.copyProperties(existingList, newList);

            shoppingListRepository.save(newList);
            return responseMessage.getSuccessMessage();
        }catch (Exception e){
            System.out.println(e);
            return responseMessage.getInternalServerErrorMesage();
        }
    }

    public ResponseBody deleteFromList(int id){
        try{
            shoppingListRepository.deleteById(id);
            return responseMessage.getSuccessMessage();
        }catch (Exception e){
            System.out.println(e);
            return responseMessage.getInternalServerErrorMesage();
        }
    }

}
