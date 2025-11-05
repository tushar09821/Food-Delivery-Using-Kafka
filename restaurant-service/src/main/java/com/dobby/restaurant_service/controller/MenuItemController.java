package com.dobby.restaurant_service.controller;

import com.dobby.restaurant_service.dto.MenuItemRequestDto;
import com.dobby.restaurant_service.service.MenuItemService;
import com.dobby.restaurant_service.util.ApiResponse;
import jakarta.ws.rs.Path;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/menu")
public class MenuItemController {
         @Autowired
        private MenuItemService menuItemService;

        @PostMapping()
        public ResponseEntity<ApiResponse> createMenuItems(@RequestParam int restId, @RequestBody MenuItemRequestDto menuItemRequestDto){
          return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponse.success("Menu Item Added",menuItemService.createMenuItem(restId,menuItemRequestDto)));
        }
        @GetMapping("{restId}/available")
        public ResponseEntity<ApiResponse> getAllAvailableFoods(@PathVariable int resId){
           return ResponseEntity.status(HttpStatus.OK).body(ApiResponse.success("List Of Available foods",menuItemService.getAllFoodItems(resId)));
        }
        @PatchMapping("/{id}")
        public ResponseEntity<ApiResponse> updateMenu(@PathVariable int id, @RequestBody MenuItemRequestDto menuItemRequestDto){
            return ResponseEntity.status(HttpStatus.OK).body(ApiResponse.success("Updated",menuItemService.updateMenuItem(id,menuItemRequestDto)));
        }
        @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> getMenuItemById(@PathVariable int id){
            return ResponseEntity.status(HttpStatus.OK).body(ApiResponse.success("MenuItem Details ",menuItemService.getMenuById(id)));
        }
        @DeleteMapping("/{menuId}")
        public ResponseEntity<ApiResponse> deleteMenuItem(@RequestParam int restId, @PathVariable int menuId){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(ApiResponse.success("Deleted Successfully",menuItemService.deleteMenuItem(restId,menuId)));
        }
}
