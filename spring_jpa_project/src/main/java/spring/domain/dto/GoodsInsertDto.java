package spring.domain.dto;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;
import spring.domain.entity.Goods;
import spring.domain.entity.MyCategory;

@Data
public class GoodsInsertDto {

	private int first;
	private int second;
	private int third;
	private int detail;
	
	private MultipartFile goodsFile;
	private String title;
	private int fixedPrice;
	private String saleOpt;
	private int saleData;
	private int stock;
	private String content;
	
	public Goods toEntity() {
		//세일여부에따라 다르게 부여
		int salePrice=0;//할인되는 가격
		int saleRate=0;//할인률
		if(saleOpt.equals("rate")) {
			salePrice=(int)(fixedPrice*((double)(saleData)/100));
			saleRate=saleData;
		}else if(saleOpt.equals("price")) {
			saleRate=(int)((double)saleData/fixedPrice*100);
		}
		int code=first+second+third+detail;
		return Goods.builder()
				.title(title)
				.fixedPrice(fixedPrice)
				.salePrice(salePrice)
				.saleRate(saleRate)
				.stock(stock)
				.content(content)
				.Category(MyCategory.builder().code(code).build())
				.build(); 
	}
	
}
