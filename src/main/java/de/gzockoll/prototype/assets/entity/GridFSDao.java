package de.gzockoll.prototype.assets.entity;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;

@Component
public class GridFSDao {
    @Autowired
    private GridFsTemplate template;

    public void save(Asset a) {
        DBObject metaData=new BasicDBObject();
        template.store(new ByteArrayInputStream(a.getData()),a.getFilename());

    }

    public Asset findOne(String id) {
        Query query=new Query();
        return new Asset(template.findOne(query));
    }
}
