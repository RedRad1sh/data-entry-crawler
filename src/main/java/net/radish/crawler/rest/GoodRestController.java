package net.radish.crawler.rest;

import net.radish.crawler.model.Good;
import net.radish.crawler.service.GoodService;
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
@RequestMapping("/api/v1/goods/")
public class GoodRestController {

    @Autowired
    private GoodService goodService;

    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Good> getGood(@PathVariable("id") Long goodID) {
        if (goodID == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Good good = goodService.getById(goodID);
        if (good == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(good, HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Good> saveGood(@RequestBody @Valid Good good) {
        if (good == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        HttpHeaders headers = new HttpHeaders();
        this.goodService.save(good);
        return new ResponseEntity<>(good, headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Good> updateGood(@RequestBody @Valid Good good, UriComponentsBuilder builder) {
        if (good == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        HttpHeaders headers = new HttpHeaders();
        this.goodService.save(good);
        return new ResponseEntity<>(good, headers, HttpStatus.OK);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Good> deleteGood(@PathVariable("id") Long goodID) {
        if (goodID == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Good good = goodService.getById(goodID);
        if (good == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        this.goodService.delete(goodID);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Good>> getAllGoods() {
        List<Good> goods = this.goodService.getAll();
        if (goods.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(goods, HttpStatus.OK);
    }
}
