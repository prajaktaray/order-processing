/*
 * package com.bulkorder.kafkaorderproducer.model;
 * 
 * 
 * import javax.persistence.AttributeConverter; import
 * javax.persistence.Converter;
 * 
 * import com.fasterxml.jackson.databind.ObjectMapper;
 * 
 * @Converter(autoApply = true) public class PaymentModelConverter implements
 * AttributeConverter<PaymentModel, String>{
 * 
 * private final static ObjectMapper objectMapper = new ObjectMapper();
 * 
 * @Override public String convertToDatabaseColumn(PaymentModel myCustomObject)
 * { try { return objectMapper.writeValueAsString(myCustomObject); } catch
 * (Exception ex) { return null; } }
 * 
 * @Override public PaymentModel convertToEntityAttribute(String dbData) { try {
 * return objectMapper.readValue(dbData, PaymentModel.class); } catch (Exception
 * ex) { return null; } }
 * 
 * 
 * }
 */