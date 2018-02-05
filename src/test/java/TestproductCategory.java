import com.jftshop.dao.MemberRepository;
import com.jftshop.dao.ProductCategoryRepository;
import com.jftshop.entity.Member;
import com.jftshop.entity.ProductCategory;
import com.jftshop.service.ProductCategoryService;
import com.jftshop.util.JFTStringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-context.xml" })
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
public class TestproductCategory {


    @Autowired
    ProductCategoryRepository productCategoryRepository;

    @Autowired
    ProductCategoryService productCategoryService;

//    @Test
//    @Transactional
//    public void  test() throws Exception {
//
//        ProductCategory pc = new ProductCategory();
//        pc.setId( JFTStringUtils.get32UUID() );
//        pc.setName("女装");
//
//        ProductCategory pc2 = new ProductCategory();
//        pc2.setId( JFTStringUtils.get32UUID() );
//        pc2.setName("女装");
//
//        pc2.setParent( pc );
//
//        productCategoryRepository.save( pc );
//
//        productCategoryRepository.save( pc2 );
//
//
//        List<ProductCategory> list = productCategoryRepository.findByName( "女装" );
//
//        System.out.println("---------------------->" + list.size() );
//
//    }


    @Test
    @Transactional
    public void  test2() throws Exception {

        List<ProductCategory> list = productCategoryService.findTree();



        System.out.println("---------------------->" + list.size() );


        ProductCategory pc =  list.get(0);


        System.out.println("---------------------->" + pc.getChildren().size() );

    }

}