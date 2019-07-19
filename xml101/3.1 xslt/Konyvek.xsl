<?xml version="1.0"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
  <xsl:output method="html"/>

  <xsl:template match="/">
    <!-- gyökér 'template'-je -->
    <html>
      <head>
        <title>Könyvesbolt</title>
      </head>
      <body>
        <h1>Könyvesbolt</h1>
		<table>
		<tr>
			<th>Cím</th>
			<th>Kategória</th>
		</tr>
			<xsl:apply-templates select="könyvesbolt" />
		</table>
      </body>
    </html>
  </xsl:template>

  <xsl:template match="könyvesbolt">
    <xsl:apply-templates select="könyv" />
  </xsl:template>

  <xsl:template match="könyv">
    <tr>
      <td><xsl:value-of select="cím"/></td>
	  <td><i><xsl:value-of select="@katergória"/></i></td>
    </tr>
  </xsl:template>

</xsl:stylesheet>