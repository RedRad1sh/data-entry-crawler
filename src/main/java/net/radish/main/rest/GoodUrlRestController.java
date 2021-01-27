package net.radish.main.rest;


import net.radish.main.model.GoodUrl;
import net.radish.main.service.GoodService;
import net.radish.main.service.GoodUrlService;
import net.radish.main.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping("/api/v1/goodurl/")
public class GoodUrlRestController {

    @Autowired
    KafkaTemplate<String, GoodUrl> kafkaTemplate;

    private static final String TOPIC = "Example";

    @Autowired
    private GoodUrlService goodUrlService;

    @Autowired
    private ShopService shopService;

    @Autowired
    private GoodService goodService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GoodUrl> getGoodUrl(@PathVariable("id") Long categoryId) {
        if (categoryId == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        GoodUrl goodUrl = goodUrlService.findOne(categoryId);
        if (goodUrl == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(goodUrl, HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GoodUrl> saveGoodUrl(@RequestBody @Valid GoodUrl id) {
        if (id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        HttpHeaders headers = new HttpHeaders();
        this.goodUrlService.save(id);
        return new ResponseEntity<>(id, headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GoodUrl> updateGoodUrl(@RequestBody @Valid GoodUrl goodUrl, UriComponentsBuilder builder) {
        if (goodUrl == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        HttpHeaders headers = new HttpHeaders();
        if (goodUrl.getUrl().indexOf("https://") == -1){
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
        goodUrl.setGood(goodService.findOne(goodUrl.getGood().getId()));
        goodUrl.setShop(shopService.findOne(goodUrl.getShop().getId()));
        goodUrl.setCreateDate(new Timestamp(System.currentTimeMillis()));
        this.goodUrlService.save(goodUrl);
        kafkaTemplate.send(TOPIC, goodUrl.getId().toString(), goodUrl);
        return new ResponseEntity<>(goodUrl, headers, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GoodUrl> deleteGoodUrl(@PathVariable("id") Long id) {
        if (id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        GoodUrl goodUrl = goodUrlService.findOne(id);
        if (goodUrl == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        goodUrl.setGood(null);
        goodUrl.setShop(null);
        this.goodUrlService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<GoodUrl>> getAllGoodUrls() {
        List<GoodUrl> goodUrls = this.goodUrlService.getAll();
        if (goodUrls.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(goodUrls, HttpStatus.OK);
    }
}
