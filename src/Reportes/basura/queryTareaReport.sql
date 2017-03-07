SELECT
     tarea.`CodigoTarea` AS tarea_CodigoTarea,
     tarea.`DescripcionTarea` AS tarea_DescripcionTarea,
     tarea.`FechaRecepcionTarea` AS tarea_FechaRecepcionTarea,
     tarea.`FechaEstimadaTarea` AS tarea_FechaEstimadaTarea,
     tarea.`FechaFinalizacionTarea` AS tarea_FechaFinalizacionTarea,
     bitacora.`CodigoInvolucrado` AS bitacora_CodigoInvolucrado,
     naturaleza.`TipoNaturaleza` AS naturaleza_TipoNaturaleza,
     naturaleza.`PrioridadNaturaleza` AS naturaleza_PrioridadNaturaleza,
     institucion.`NombreInstitucion` AS institucion_NombreInstitucion,
     persona.`NombrePersona` AS persona_NombrePersona,
     bitacora.`CorrelativoBitacora` AS bitacora_CorrelativoBitacora,
     bitacora.`FechaBitacora` AS bitacora_FechaBitacora
FROM
     `naturaleza` naturaleza INNER JOIN `tarea` tarea ON naturaleza.`CodigoNaturaleza` = tarea.`CodigoNaturaleza`
     INNER JOIN `bitacora` bitacora ON naturaleza.`CodigoNaturaleza` = bitacora.`CodigoNaturaleza`
     AND tarea.`CodigoTarea` = bitacora.`CodigoTarea`
     INNER JOIN `involucrado` involucrado ON bitacora.`CodigoInvolucrado` = involucrado.`CodigoInvolucrado`
     AND tarea.`CodigoTarea` = involucrado.`CodigoTarea`
     AND naturaleza.`CodigoNaturaleza` = involucrado.`CodigoNaturaleza`
     INNER JOIN `persona` persona ON involucrado.`CodigoPersona` = persona.`CodigoPersona`
     INNER JOIN `institucion` institucion ON naturaleza.`CodigoInstitucion` = institucion.`CodigoInstitucion`