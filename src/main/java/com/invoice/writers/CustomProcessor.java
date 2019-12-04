package com.invoice.writers;

import java.util.Iterator;
import java.util.List;

import javax.batch.api.chunk.ItemProcessor;

import com.invoices.model.Batch;
import com.invoices.model.Document;
import com.invoices.model.Section;

public class CustomProcessor implements ItemProcessor {

	public Object processItem(Object item) throws Exception {
		// TODO Auto-generated method stub

		Batch batch = (Batch) item;
		List<Section> sections = batch.getSections();
		for (Iterator<Section> iterator2 = sections.iterator(); iterator2.hasNext();) {
			Section section = iterator2.next();
			System.out.println("Section ID" + section.getId());
			List<Document> documents = section.getDocument();
			for (Iterator<Document> iterator3 = documents.iterator(); iterator3.hasNext();) {
				Document document = iterator3.next();
				System.out.println("Document ID " + document.getId() + " "+ document.getDistribution() + " "+ document.getBgcId());

			}
		}

		return null;
	}

}