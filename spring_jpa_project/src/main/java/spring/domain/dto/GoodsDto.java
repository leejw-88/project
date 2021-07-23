package spring.domain.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import spring.domain.entity.Goods;

@RequiredArgsConstructor
@Data
public class GoodsDto {
	private long no;
	private String title;
	private int fixedPrice;
	private double saleRate;
	private int salePrice;
	private int stock;
	
	public GoodsDto(Goods entity) {
		this.no = entity.getNo();
		this.title = entity.getTitle();
		this.fixedPrice = entity.getFixedPrice();
		this.saleRate=entity.getSaleRate();
		this.salePrice = entity.getSalePrice();
		this.stock = entity.getStock();
	}
	
	
	
}
