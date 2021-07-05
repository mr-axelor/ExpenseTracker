<?xml version="1.0" encoding="utf-8"?>
<expense-order>
	<title>$expense$</title>
	<date>$date1$</date>
	<price>$customer.fullName; format="escape"$</price>
$category: { it |
	<item>
		<product>$it.categoryName; format="selection:product.color.selection"$</product>
	</item>
}$
</expense-order>