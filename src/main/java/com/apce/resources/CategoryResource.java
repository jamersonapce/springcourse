package com.apce.resources;

import java.net.URI;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.apce.domains.Category;
import com.apce.domains.dtos.categories.CategoryCreateDTO;
import com.apce.domains.dtos.categories.CategoryReadDTO;
import com.apce.domains.dtos.categories.CategoryUpdateDTO;
import com.apce.services.CategoryService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {

	private final CategoryService serv;

	@GetMapping("/{id}")
	public ResponseEntity<Category> find(@PathVariable Integer id) {
		Category obj = this.serv.find(id);
		return ResponseEntity.ok().body(obj);
	}

	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody CategoryCreateDTO dto) {
		Category result = this.serv.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(result.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@PathVariable Integer id, @RequestBody CategoryUpdateDTO dto) {
		this.serv.update(id, dto);
		return ResponseEntity.noContent().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		this.serv.delete(id);
		return ResponseEntity.noContent().build();
	}

	@GetMapping()
	public ResponseEntity<List<CategoryReadDTO>> findAll() {
		return ResponseEntity.ok().body(this.serv.findAll());
	}

	@GetMapping("/page")
	public ResponseEntity<Page<CategoryReadDTO>> findPage(
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
			@RequestParam(value = "orderBy", defaultValue = "name") String orderBy,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction) {
		return ResponseEntity.ok().body(this.serv.findPage(page, linesPerPage, orderBy, direction));
	}

}
