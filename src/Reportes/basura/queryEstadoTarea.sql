SELECT
     tarea.`CodigoTarea` AS tarea_CodigoTarea,
     tarea.`FechaFinalizacionTarea` AS tarea_FechaFinalizacionTarea,
     naturaleza.`TipoNaturaleza` AS naturaleza_TipoNaturaleza,
     naturaleza.`PrioridadNaturaleza` AS naturaleza_PrioridadNaturaleza,
     naturaleza.`CodigoNaturaleza` AS naturaleza_CodigoNaturaleza,
     bitacora.`CorrelativoBitacora` AS bitacora_CorrelativoBitacora,
     bitacora.`FechaBitacora` AS bitacora_FechaBitacora,
     persona.`CodigoPersona` AS persona_CodigoPersona,
     persona.`NombrePersona` AS persona_NombrePersona,
     involucrado.`CodigoNaturaleza` AS involucrado_CodigoNaturaleza,
     involucrado.`CodigoTarea` AS involucrado_CodigoTarea,
     involucrado.`CodigoInvolucrado` AS involucrado_CodigoInvolucrado,
     institucion.`CodigoInstitucion` AS institucion_CodigoInstitucion,
     institucion.`NombreInstitucion` AS institucion_NombreInstitucion,
     tarea.`DescripcionTarea` AS tarea_DescripcionTarea,
     tarea.`FechaRecepcionTarea` AS tarea_FechaRecepcionTarea,
     estado.`DescripcionEstado` AS estado_DescripcionEstado,
     bitacora.`ObservacionBitacora` AS bitacora_ObservacionBitacora
FROM
     `naturaleza` naturaleza INNER JOIN `tarea` tarea ON naturaleza.`CodigoNaturaleza` = tarea.`CodigoNaturaleza`
     INNER JOIN `bitacora` bitacora ON naturaleza.`CodigoNaturaleza` = bitacora.`CodigoNaturaleza`
     AND tarea.`CodigoTarea` = bitacora.`CodigoTarea`
     INNER JOIN `involucrado` involucrado ON bitacora.`CodigoInvolucrado` = involucrado.`CodigoPersona`
     INNER JOIN `estado` estado ON bitacora.`CodigoEstado` = estado.`CodigoEstado`
     AND tarea.`CodigoTarea` = involucrado.`CodigoTarea`
     AND naturaleza.`CodigoNaturaleza` = involucrado.`CodigoNaturaleza`
     INNER JOIN `persona` persona ON involucrado.`CodigoPersona` = persona.`CodigoPersona`
     INNER JOIN `institucion` institucion ON naturaleza.`CodigoInstitucion` = institucion.`CodigoInstitucion`