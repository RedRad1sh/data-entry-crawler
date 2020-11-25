package net.radish.crawler.rest;


import net.radish.crawler.model.Category;
import net.radish.crawler.model.Shop;
import net.radish.crawler.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/shop/")
public class ShopRestController {
    @Autowired
    private ShopService shopService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Shop> getCategory(@PathVariable("id") Long id) {
        if (id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Shop shop = shopService.getById(id);
        if (shop == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(shop, HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Shop> saveGood(@RequestBody @Valid Shop shop) {
        if (shop == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        HttpHeaders headers = new HttpHeaders();
        this.shopService.save(shop);
        return new ResponseEntity<>(shop, headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Shop> updateGood(@RequestBody @Valid Shop shop, UriComponentsBuilder builder) {
        if (shop == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        HttpHeaders headers = new HttpHeaders();
        this.shopService.save(shop);
        return new ResponseEntity<>(shop, headers, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Shop> deleteGood(@PathVariable("id") Long id) {
        if (id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Shop shop = shopService.getById(id);
        if (shop == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        this.shopService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Shop>> getAllGoods() {
        List<Shop> shops = this.shopService.getAll();
        if (shops.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(shops, HttpStatus.OK);
    }
}
