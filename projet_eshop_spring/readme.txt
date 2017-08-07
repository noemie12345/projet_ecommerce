Problèmes rencontrés:
	Avec l'utilisation de Long pour la définition des ID, il faut faire attention à 
	les déclarer en tant que types primitifs et non en tant que Classe pour ne pas avoir de problèmes 
	sur les méthodes de DAO par la suite. 
	On utilise donc long et non Long pour définir les attributs des classes concernées.

Pour que le menu déroulant des produits répertoriant les catégories fonctionne, il faut que la base de donnée soit configurée en validate et 
non en create.

Bouton boolean dans ajoutProduit : 
<h:outputText value="Selectionné: " />
			<p:selectBooleanButton id="value1" value="#{produitMB.valeur}"
				onLabel="Oui" offLabel="Non" onIcon="ui-icon-check" style="width:60px" />


			<p:outputLabel for="idSelectionne" value="Selectionne: " />
			<p:inputMask id="idSelectionne" value="#{produitMB.produit.selectionne}" />
			
ajoutProduit.xhtml:

<p:outputLabel for="idSelectionne" value="Selectionne" />
			<p:selectOneMenu id="idSelectionne" value="#{produitMB.produit}">
				<f:selectItem itemLabel="Selectionnez une valeur" itemValue="" />
				<f:selectItems value="#{produitMB.listeProduits}" itemLabel="#{produit.selectionne}" itemValue="#{produit}" />
			</p:selectOneMenu>

<p:outputLabel for="idSelectionne" value="Selectionne:" />
			<p:selectOneMenu id="idSelectionne"
				value="#{selectOneMenuView.selectionne}" style="width:125px">
				<f:selectItem itemLabel="Selectionnez" itemValue="" />
				<f:selectItem itemLabel="Xbox One" itemValue="Xbox One" />
				<f:selectItem itemLabel="PS4" itemValue="PS4" />
				<f:selectItem itemLabel="Wii U" itemValue="Wii U" />
			</p:selectOneMenu>
			
			
			
<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:f="http://java.sun.com/jsf/core"
	xmlns:p="http://primefaces.org/ui">

<h:head>
	<title>Administrateur produit</title>
</h:head>

<ui:insert name="header">
	<ui:include src="templates/headerTemplateProduit.xhtml"></ui:include>
</ui:insert>

<h:body>
	<h:form>
		<h:panelGrid columns="2" cellpadding="5">
			<p:outputLabel for="idDesignation" value="Nom du produit" />
			<p:inputMask id="idDesignation"
				value="#{produitMB.produit.designation}" />

			<p:outputLabel for="idDescription" value="Description" />
			<p:inputMask id="idDescription"
				value="#{produitMB.produit.description}" />

			<p:outputLabel for="idPrix" value="Prix" />
			<p:inputMask id="idPrix" value="#{produitMB.produit.prix}" />

			<p:outputLabel for="idQuantite" value="Quantité" />
			<p:inputMask id="idQuantite" value="#{produitMB.produit.quantite}" />

			<p:outputLabel for="selectionne" value="Selectionne:" />
			<p:inputMask id="selectionne" value="#{produitMB.produit.selectionne}" />

			<p:outputLabel for="categorie" value="Categorie: " />
			<p:selectOneMenu id="categorie" value="#{selectOneMenuView.categorie}">
				<f:selectItem itemLabel="Selectionnez une valeur" itemValue="" />
				<f:selectItems value="#{selectOneMenuView.categories}" />
			</p:selectOneMenu>

			<p:commandButton value="Ajouter" id="ajouter" update="@all"
				action="#{produitMB.ajouterProduit}"
				styleClass="ui-priority-primary" />

		</h:panelGrid>
	</h:form>

</h:body>
</html>


pour supprimer produit
<!-- 			<p:outputLabel for="idSelectionne" value="Selectionne " /> -->
<!--         <p:selectOneMenu id="idSelectionne" value="#{selectOneMenuView.car}"> -->
<!--             <f:selectItem itemLabel="Choisissez" itemValue="" /> -->
<!--             <f:selectItems value="#{selectOneMenuView.cars}" /> -->
<!--         </p:selectOneMenu> -->	

pour ajouter produit sur la catégorie:
			<p:outputLabel for="categorie" value="Categorie" />
			<p:selectOneMenu id="categorie" value="#{categorieMB.nomCat}">
				<f:selectItem itemLabel="Selectionnez une valeur" itemValue="" />
				<f:selectItems value="#{categorieMB.categories}" />
			</p:selectOneMenu>	
			
<h:form>
		<p:dataTable var="produit" value="#{produitMB.listeProduits}">
			<p:column headerText="Nom du produit">
				<h:outputText value="#{produit.designation}" />
			</p:column>

			<p:column headerText="Description">
				<h:outputText value="#{produit.description}" />
			</p:column>

			<p:column headerText="Prix">
				<h:outputText value="#{produit.prix}" />
			</p:column>

			<p:column headerText="Quantité">
				<h:outputText value="#{produit.quantite}" />
			</p:column>

			<p:column headerText="Catégorie">
				<h:outputText value="#{produit.categorie.nomCategorie}" />
			</p:column>

			<p:column headerText="Opérations">
				<p:commandButton value="Supprimer" id="supprimer" update="@all"
					action="#{produitMB.supprimerProduit}"
					styleClass="ui-priority-primary">
					<f:setPropertyActionListener value="#{produit.idProduit}"
						target="#{produitMB.produit.idProduit}" />
				</p:commandButton>
			</p:column>
		</p:dataTable>

	</h:form>