<?xml version="1.0"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:output method="html"/>

<xsl:template match="/"><!-- gyökér 'template'-je -->
<html>
<head>
  <title>XML Levél</title>
</head>
<body>
<h1>Levél</h1>
<xsl:apply-templates select="Level" /><!-- alkalmazzuk 'Level' 'template'-jét -->
</body>
</html>
</xsl:template>

<xsl:template match="Level">  <!-- 'Level' template -->
  <p>Feladó: <xsl:apply-templates select="Kitol" /><!-- alkalmazzuk 'Kitol' beépített 'template'-jét --></p>
  <p>Címzett: <xsl:apply-templates select="Kinek" /></p>
  <hr />
  <p>Szöveg: <xsl:apply-templates select="Uzenet" /></p>
  (<small>Azonosító: <xsl:value-of select="@id"/><!-- 'id' attribútum értéke --></small>)
</xsl:template>

</xsl:stylesheet>