package com.dsp.departmentservice.controller;

import com.dsp.departmentservice.model.request.DepartmentRequest;
import com.dsp.departmentservice.model.response.Response;
import com.dsp.departmentservice.service.DepartmentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    private DepartmentService service;

    @Autowired
    public DepartmentController(DepartmentService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<Response> getAll(){
        var result = this.service.getAll();
        return ResponseEntity.ok(
                new Response(200, "Success", result)
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response> getById(@PathVariable("id") String id){
        var result = this.service.getById(id);
        return ResponseEntity.ok(
                new Response(200, "Success", result)
        );
    }

    @PostMapping
    public ResponseEntity<Response> create(
            @RequestBody @Valid DepartmentRequest request
            ){
        var result = this.service.save(request).orElse(null);
        if(result == null){
            return ResponseEntity.ok(
                    new Response(500, "Failed", null)
            );
        }
        return ResponseEntity.ok(
                new Response(200, "Success", result)
        );
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Response> update(
            @PathVariable("id") String id,
            @RequestBody @Valid DepartmentRequest request){
        var result = this.service.update(id,request).orElse(null);
        if(result == null){
            return ResponseEntity.ok(
                    new Response(500, "Failed", null)
            );
        }
        return ResponseEntity.ok(
                new Response(200, "Success", result)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response> delete(@PathVariable("id") String id){
        var result = this.service.delete(id).orElse(null);
        if(result == null){
            return ResponseEntity.ok(
                    new Response(500, "Failed", null)
            );
        }
        return ResponseEntity.ok(
                new Response(200, "Success", result)
        );
    }
}
