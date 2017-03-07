SELECT
     bitacora.`CodigoNaturaleza` AS bitacora_CodigoNaturaleza,
     bitacora.`CodigoTarea` AS bitacora_CodigoTarea,
     bitacora.`CorrelativoBitacora` AS bitacora_CorrelativoBitacora,
     bitacora.`CodigoEstado` AS bitacora_CodigoEstado,
     bitacora.`CodigoInvolucrado` AS bitacora_CodigoInvolucrado,
     bitacora.`FechaBitacora` AS bitacora_FechaBitacora,
     estado.`CodigoEstado` AS estado_CodigoEstado,
     estado.`DescripcionEstado` AS estado_DescripcionEstado,
     involucrado.`CodigoNaturaleza` AS involucrado_CodigoNaturaleza,
     involucrado.`CodigoTarea` AS involucrado_CodigoTarea,
     involucrado.`CodigoInvolucrado` AS involucrado_CodigoInvolucrado,
     involucrado.`CodigoPersona` AS involucrado_CodigoPersona,
     persona.`CodigoPersona` AS persona_CodigoPersona,
     persona.`NombrePersona` AS persona_NombrePersona,
     naturaleza.`CodigoInstitucion` AS naturaleza_CodigoInstitucion,
     naturaleza.`TipoNaturaleza` AS naturaleza_TipoNaturaleza,
     naturaleza.`PrioridadNaturaleza` AS naturaleza_PrioridadNaturaleza,
     naturaleza.`CodigoNaturaleza` AS naturaleza_CodigoNaturaleza,
     institucion.`CodigoInstitucion` AS institucion_CodigoInstitucion,
     institucion.`NombreInstitucion` AS institucion_NombreInstitucion,
     tarea.`CodigoTarea` AS tarea_CodigoTarea,
     tarea.`DescripcionTarea` AS tarea_DescripcionTarea,
     tarea.`FechaRecepcionTarea` AS tarea_FechaRecepcionTarea,
     tarea.`FechaFinalizacionTarea` AS tarea_FechaFinalizacionTarea,
     bitacora.`ObservacionBitacora` AS bitacora_ObservacionBitacora,
     bitacora.`HoraBitacora` AS bitacora_HoraBitacora
FROM
     `estado` estado INNER JOIN `bitacora` bitacora ON estado.`CodigoEstado` = bitacora.`CodigoEstado`
     LEFT OUTER JOIN `involucrado` involucrado ON bitacora.`CodigoInvolucrado` = involucrado.`CodigoInvolucrado`
     AND involucrado.`CodigoNaturaleza` = bitacora.`CodigoNaturaleza`
     AND involucrado.`CodigoTarea` = bitacora.`CodigoTarea`
     INNER JOIN `naturaleza` naturaleza ON bitacora.`CodigoNaturaleza` = naturaleza.`CodigoNaturaleza`
     INNER JOIN `tarea` tarea ON bitacora.`CodigoTarea` = tarea.`CodigoTarea`
     AND tarea.`CodigoNaturaleza` = bitacora.`CodigoNaturaleza`
     AND involucrado.`CodigoNaturaleza` = tarea.`CodigoNaturaleza`
     AND involucrado.`CodigoTarea` = tarea.`CodigoTarea`
     INNER JOIN `persona` persona ON involucrado.`CodigoPersona` = persona.`CodigoPersona`
     INNER JOIN `institucion` institucion ON naturaleza.`CodigoInstitucion` = institucion.`CodigoInstitucion`