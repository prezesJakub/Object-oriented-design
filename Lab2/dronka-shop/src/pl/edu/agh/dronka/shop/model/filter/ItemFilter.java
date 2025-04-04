package pl.edu.agh.dronka.shop.model.filter;

import pl.edu.agh.dronka.shop.model.Item;

public class ItemFilter {

	private FilterSpecification filter = new FilterSpecification();

	public FilterSpecification getFilterSpec() {
		return filter;
	}
	public boolean appliesTo(Item item) {
		if (filter.getCategory() != null
				&& !filter.getCategory().equals(item.getCategory())) {
			return false;
		}

		// applies filter only if the flag (secondHand) is true)
		if (filter.isSecondhand() && !item.isSecondhand()) {
			return false;
		}

		// applies filter only if the flag (polish) is true)
		if (filter.isPolish() && !item.isPolish()) {
			return false;
		}

		return item.hasAdditionalProperties(filter);
	}

}