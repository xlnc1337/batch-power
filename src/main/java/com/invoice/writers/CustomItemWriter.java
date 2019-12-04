package com.invoice.writers;

import java.util.Iterator;
import java.util.List;

import org.springframework.batch.item.ItemWriter;

import com.invoices.model.Batch;
import com.invoices.model.Document;
import com.invoices.model.Section;
 
public class CustomItemWriter implements ItemWriter<Object> {
 
	

	public void write(List item) throws Exception {
		// TODO Auto-generated method stub
		for (Iterator<Batch> iterator = item.iterator(); iterator.hasNext();) {
			Batch object = iterator.next();
			System.out.println("BatchID :"+object.getId());
			
			List<Section> sections = object.getSections();
			for (Iterator<Section> iterator2 = sections.iterator(); iterator2.hasNext();) {
				Section section =  iterator2.next();
				System.out.println("Section ID"+section.getId());
				List<Document> documents = section.getDocument();
				for (Iterator<Document> iterator3 = documents.iterator(); iterator3.hasNext();) {
					Document document = iterator3.next();
					System.out.println("Document ID "+document.getId()+" "+document.getDistribution()+" "+document.getBgcId());
					
				}
			}
		}
	}
}