package pl.edu.agh.dronka.shop.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JPanel;

import pl.edu.agh.dronka.shop.controller.ShopController;
import pl.edu.agh.dronka.shop.model.Category;
import pl.edu.agh.dronka.shop.model.filter.ItemFilter;

public class PropertiesPanel extends JPanel {

	private static final long serialVersionUID = -2804446079853846996L;
	private ShopController shopController;

	private ItemFilter filter = new ItemFilter();

	public PropertiesPanel(ShopController shopController) {
		this.shopController = shopController;
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
	}

	public void fillProperties(Category category) {
		removeAll();

		filter.getFilterSpec().setCategory(shopController.getCurrentCategory());
		add(createPropertyCheckbox("Tanie bo polskie", new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {
				filter.getFilterSpec().setPolish(
						((JCheckBox) event.getSource()).isSelected());
				shopController.filterItems(filter);
			}
		}));

		add(createPropertyCheckbox("Używany", new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {
				filter.getFilterSpec().setSecondhand(
						((JCheckBox) event.getSource()).isSelected());
				shopController.filterItems(filter);
			}
		}));

		switch(category) {
			case BOOKS: {
				add(createPropertyCheckbox("Twarda oprawa", new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent event) {
						filter.getFilterSpec().setHardcover(
								((JCheckBox) event.getSource()).isSelected());
						shopController.filterItems(filter);
					}
				}));
				break;
			}
			case ELECTRONICS: {
				add(createPropertyCheckbox("Mobilny", new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent event) {
						filter.getFilterSpec().setMobile(
								((JCheckBox) event.getSource()).isSelected());
						shopController.filterItems(filter);
					}
				}));
				add(createPropertyCheckbox("Gwarancja", new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent event) {
						filter.getFilterSpec().setWarranty(
								((JCheckBox) event.getSource()).isSelected());
						shopController.filterItems(filter);
					}
				}));
				break;
			}
			case FOOD, SPORT: {
				break;
			}
			case MUSIC: {
				add(createPropertyCheckbox("Dołączone wideo", new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent event) {
						filter.getFilterSpec().setVideoAdded(
								((JCheckBox) event.getSource()).isSelected());
						shopController.filterItems(filter);
					}
				}));
				break;
			}
		}

	}

	private JCheckBox createPropertyCheckbox(String propertyName,
			ActionListener actionListener) {

		JCheckBox checkBox = new JCheckBox(propertyName);
		checkBox.setSelected(false);
		checkBox.addActionListener(actionListener);

		return checkBox;
	}

}
