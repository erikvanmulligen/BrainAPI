/**
 * 
 */
package com.euretos.brain;

/**
 * (C) 2013,2014 Science and Technology Corporation, Delft, The Netherlands
 *
 * @author Erik van Mulligen
 * 
 *
 */
public class SemanticType {

	private static Object[][] semantictypes = {{71,"Entity"},
					{77,"Conceptual Entity"},
					{78,"Idea or Concept"},
					{169,"Functional Concept"},
					{22,"Body System"},
					{79,"Temporal Concept"},
					{80,"Qualitative Concept"},
					{81,"Quantitative Concept"},
					{82,"Spatial Concept"},
					{29,"Body Location or Region"},
					{30,"Body Space or Junction"},
					{83,"Geographic Area"},
					{85,"Molecular Sequence"},
					{86,"Nucleotide Sequence"},
					{87,"Amino Acid Sequence"},
					{88,"Carbohydrate Sequence"},
					{33,"Finding"},
					{34,"Laboratory or Test Result"},
					{184,"Sign or Symptom"},
					{32,"Organism Attribute"},
					{201,"Clinical Attribute"},
					{170,"Intellectual Product"},
					{185,"Classification"},
					{89,"Regulation or Law"},
					{171,"Language"},
					{90,"Occupation or Discipline"},
					{91,"Biomedical Occupation or Discipline"},
					{92,"Organization"},
					{93,"Health Care Related Organization"},
					{94,"Professional Society"},
					{95,"Self-help or Relief Organization"},
					{102,"Group Attribute"},
					{96,"Group"},
					{100,"Age Group"},
					{99,"Family Group"},
					{97,"Professional or Occupational Group"},
					{98,"Population Group"},
					{101,"Patient or Disabled Group"},
					{72,"Physical Object"},
					{17,"Anatomical Structure"},
					{190,"Anatomical Abnormality"},
					{19,"Congenital Abnormality"},
					{20,"Acquired Abnormality"},
					{18,"Embryonic Structure"},
					{21,"Fully Formed Anatomical Structure"},
					{23,"Body Part, Organ, or Organ Component"},
					{25,"Cell"},
					{26,"Cell Component"},
					{24,"Tissue"},
					{28,"Gene or Genome"},
					{73,"Manufactured Object"},
					{200,"Clinical Drug"},
					{74,"Medical Device"},
					{75,"Research Device"},
					{1,"Organism"},
					{8,"Animal"},
					{9,"Invertebrate"},
					{10,"Vertebrate"},
					{11,"Amphibian"},
					{12,"Bird"},
					{13,"Fish"},
					{15,"Mammal"},
					{16,"Human"},
					{14,"Reptile"},
					{194,"Archaeon"},
					{7,"Bacterium"},
					{4,"Fungus"},
					{2,"Plant"},
					{3,"Alga"},
					{5,"Virus"},
					{6,"Rickettsia or Chlamydia"},
					{167,"Substance"},
					{31,"Body Substance"},
					{103,"Chemical"},
					{120,"Chemical Viewed Functionally"},
					{123,"Biologically Active Substance"},
					{124,"Neuroreactive Substance or Biogenic Amine"},
					{125,"Hormone"},
					{126,"Enzyme"},
					{127,"Vitamin"},
					{129,"Immunologic Factor"},
					{192,"Receptor"},
					{122,"Biomedical or Dental Material"},
					{121,"Pharmacologic Substance"},
					{195,"Antibiotic"},
					{130,"Indicator, Reagent, or Diagnostic Aid"},
					{131,"Hazardous or Poisonous Substance"},
					{104,"Chemical Viewed Structurally"},
					{109,"Organic Chemical"},
					{116,"Amino Acid, Peptide, or Protein"},
					{118,"Carbohydrate"},
					{119,"Lipid"},
					{111,"Eicosanoid"},
					{110,"Steroid"},
					{114,"Nucleic Acid, Nucleoside, or Nucleotide"},
					{115,"Organophosphorus Compound"},
					{197,"Inorganic Chemical"},
					{196,"Element, Ion, or Isotope"},
					{168,"Food"},
					{51,"Event"},
					{52,"Activity"},
					{53,"Behavior"},
					{54,"Social Behavior"},
					{55,"Individual Behavior"},
					{56,"Daily or Recreational Activity"},
					{57,"Occupational Activity"},
					{65,"Educational Activity"},
					{64,"Governmental or Regulatory Activity"},
					{58,"Health Care Activity"},
					{60,"Diagnostic Procedure"},
					{59,"Laboratory Procedure"},
					{61,"Therapeutic or Preventive Procedure"},
					{62,"Research Activity"},
					{63,"Molecular Biology Research Technique"},
					{66,"Machine Activity"},
					{67,"Phenomenon or Process"},
					{68,"Human-caused Phenomenon or Process"},
					{69,"Environmental Effect of Humans"},
					{37,"Injury or Poisoning"},
					{70,"Natural Phenomenon or Process"},
					{38,"Biologic Function"},
					{39,"Physiologic Function"},
					{43,"Cell Function"},
					{44,"Molecular Function"},
					{45,"Genetic Function"},
					{42,"Organ or Tissue Function"},
					{40,"Organism Function"},
					{41,"Mental Process"},
					{46,"Pathologic Function"},
					{49,"Cell or Molecular Dysfunction"},
					{47,"Disease or Syndrome"},
					{48,"Mental or Behavioral Dysfunction"},
					{191,"Neoplastic Process"},
					{50,"Experimental Model of Disease"},
					{166,"associated_with"},
					{132,"physically_related_to"},
					{198,"branch_of"},
					{174,"connected_to"},
					{172,"consists_of"},
					{134,"contains"},
					{202,"ingredient_of"},
					{175,"interconnects"},
					{133,"part_of"},
					{199,"tributary_of"},
					{189,"spatially_related_to"},
					{173,"adjacent_to"},
					{135,"location_of"},
					{176,"surrounds"},
					{177,"traverses"},
					{139,"functionally_related_to"},
					{151,"affects"},
					{153,"manages"},
					{154,"treats"},
					{146,"disrupts"},
					{149,"complicates"},
					{142,"interacts_with"},
					{148,"prevents"},
					{187,"brings_about"},
					{144,"produces"},
					{147,"causes"},
					{188,"performs"},
					{141,"carries_out"},
					{145,"exhibits"},
					{143,"practices"},
					{152,"occurs_in"},
					{140,"process_of"},
					{155,"uses"},
					{150,"manifestation_of"},
					{156,"indicates"},
					{157,"result_of"},
					{136,"temporally_related_to"},
					{137,"co-occurs_with"},
					{138,"precedes"},
					{158,"conceptually_related_to"},
					{193,"analyzes"},
					{164,"assesses_effect_of"},
					{160,"conceptual_part_of"},
					{161,"evaluation_of"},
					{180,"degree_of"},
					{182,"measurement_of"},
					{162,"measures"},
					{163,"diagnoses"},
					{159,"property_of"},
					{178,"derivative_of"},
					{179,"developmental_form_of"},
					{183,"method_of"},
					{165,"issue_in"},
					{186,"isa"}};
	
	public static Integer convert( String name ){
		for (int i = 0 ; i < semantictypes.length ; i++ ){
			if ( semantictypes[i][1].toString().equals(name)){
				return (Integer)semantictypes[i][0];
			}
		}
		return null;
	}
}