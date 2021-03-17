package app.core.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import app.core.beans.Item;

@RestController
@CrossOrigin
public class ItemController {

	private List<Item> items = new ArrayList<Item>();
	private int currId;

	@PostMapping("/items")
	public int save(@RequestBody Item item) {
		item.setId(++currId);
		items.add(item);
		return item.getId();
	}

	@GetMapping("/items/{id}")
	public Item getOne(@PathVariable int id) {
		Item item = new Item(id);
		int index = items.indexOf(item);
		if (index != -1) {
			return items.get(index);
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "get item failed - not found");
		}
	}

	@GetMapping("/items")
	public List<Item> getAll() {
		return items;
	}

	@PutMapping("/items")
	public Item update(@RequestBody Item item) {
		int index = items.indexOf(item);
		if (index != -1) {
			Item foundItem = items.get(index);
			foundItem.setName(item.getName());
			foundItem.setPrice(item.getPrice());
			return foundItem;
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "update item failed - not found");
		}
	}

	@DeleteMapping("/items/{id}")
	public boolean delete(@PathVariable int id) {
		Item item = new Item(id);
		return items.remove(item);
	}

	@DeleteMapping("/items")
	public void deleteAll() {
		items.clear();
		this.currId = 0;
	}

}
